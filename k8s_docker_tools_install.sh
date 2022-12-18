KUBE_DIR="$(dirname "$KUBECONFIG")"
CERT_DIR=$KUBE_DIR/certificates
INSTALL_DIR=$HOME/temp-installers
CURRENT_DIR=$PWD

check_kubeconfig(){
if test -f "$KUBECONFIG"; 
then
	make_or_remove_dir $CERT_DIR
	KUBE_API=$(grep server $KUBECONFIG  | awk '{ print $2 }' | head -n1 )
	grep client-certificate-data $KUBECONFIG  | awk '{ print $2 }' | base64 -d > $CERT_DIR/cert.pem
	grep client-key-data $KUBECONFIG  | awk '{ print $2 }' | base64 -d > $CERT_DIR/key.pem
	grep certificate-authority-data $KUBECONFIG  | awk '{ print $2 }' | base64 -d > $CERT_DIR/cacert.pem
	if test -f $CERT_DIR/cert.pem && test -f $CERT_DIR/key.pem && test -f $CERT_DIR/cacert.pem ; then
		echo -e "curl $KUBE_API/version --cacert $CERT_DIR/cacert.pem --key $CERT_DIR/key.pem --cert $CERT_DIR/cert.pem"
	fi
else
	echo -e "\nCheck if KUBECONFIG is configured in ~/.bashrc. Do printenv | grep KUBECONFIG"
fi
}
make_or_remove_dir(){
if [ -d $1 ]
then
    rm -rf $1    
fi
mkdir -p $1
}

dialog_box_for_k8s(){
#!/bin/bash
HEIGHT=15
WIDTH=40
CHOICE_HEIGHT=4
BACKTITLE="Minikube or Kind installation"
TITLE="Local Kubernetes Cluster Installation"
MENU="Choose one of the following:"

OPTIONS=(1 "Minikube"
         2 "Kind")

CHOICE=$(dialog --clear \
                --backtitle "$BACKTITLE" \
                --title "$TITLE" \
                --menu "$MENU" \
                --keep-tite \
                $HEIGHT $WIDTH $CHOICE_HEIGHT \
                "${OPTIONS[@]}" \
                2>&1 >/dev/tty)

case $CHOICE in
        1)
            curl -LO "https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64"
            sudo install minikube-linux-amd64 /usr/local/bin/minikube
            ;;
        2)
            curl -Lo ./kind "https://kind.sigs.k8s.io/dl/v0.14.0/kind-linux-amd64"
            sudo mv ./kind /bin/kind
            ;;
        *)
            echo "Exiting!"
esac
}
check_if_installed(){

make_or_remove_dir $INSTALL_DIR
cd $INSTALL_DIR
# Check required commands are available and executable in $PATH

if ! [ -x "$(command -v docker)" ]; then
  echo 'Error: docker is not installed. Hence installing'
  sudo apt update
  sudo apt install -y apt-transport-https ca-certificates curl software-properties-common
  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
  sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"
  sudo apt update
  sudo apt install -y docker-ce
  sudo systemctl status docker
fi

if ! [ -x "$(command -v crictl)" ]; then
  echo -e 'Error: crictl is not installed. Hence installing'
  VERSION="v1.24.1"
  curl -L https://github.com/kubernetes-sigs/cri-tools/releases/download/$VERSION/crictl-${VERSION}-linux-amd64.tar.gz --output crictl-${VERSION}-linux-amd64.tar.gz
  sudo tar zxvf crictl-$VERSION-linux-amd64.tar.gz -C /usr/local/bin
  rm -f crictl-$VERSION-linux-amd64.tar.gz
fi

if ! [ -x "$(command -v kubectl)" ]; then
  echo -e 'Error: kubectl is not installed. Hence installing'
  curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
  sudo install kubectl /usr/local/bin/kubectl
fi

if ! [ -x "$(command -v helm)" ]; then
  echo -e 'Error: helm is not installed'
  #exit 1
fi

dialog_box_for_k8s
check_kubeconfig

if ! [ -x "$(command -v k9s)" ]; then
  echo "k9s is not installed. Hence installing in ${INSTALL_DIR}"
  curl -Lo k9s.tgz https://github.com/derailed/k9s/releases/download/v0.26.3/k9s_Linux_x86_64.tar.gz
  tar -xf k9s.tgz
  sudo install k9s /usr/local/bin/
fi

if ! [ -x "$(command -v kubectx)" ]; then
  echo 'kubectx is not installed. Hence installing'
  curl -Lo kubectx.tgz  https://github.com/ahmetb/kubectx/releases/download/v0.9.0/kubectx_v0.9.0_linux_x86_64.tar.gz
  tar -xf kubectx.tgz
  sudo install kubectx /usr/local/bin/
fi

if ! [ -x "$(command -v kubens)" ]; then
  echo 'kubens is not installed. Hence installing'
  curl -Lo kubens.tgz  https://github.com/ahmetb/kubectx/releases/download/v0.9.0/kubens_v0.9.0_linux_x86_64.tar.gz 
  tar -xf kubens.tgz
  sudo install kubens /usr/local/bin/
fi
if ! [ -x "$(command -v fzf)" ]; then
  echo 'fzf is not installed. Hence installing'
  git clone --depth 1 https://github.com/junegunn/fzf.git ~/.fzf
  ~/.fzf/install
fi
rm -f $INSTALL_DIR/*.tgz
cd $CURRENT_DIR
}
check_if_installed