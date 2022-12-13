KUBE_DIR="$(dirname "$KUBECONFIG")"
CERT_DIR=$KUBE_DIR/certificates
INSTALL_DIR=$HOME/temp-installers
CURRENT_DIR=$PWD
make_or_remove_dir(){
if [ -d $1 ]
then
    rm -rf $1    
fi
mkdir -p $1
}

check_if_installed(){
# Check required commands are available and executable in $PATH
if ! [ -x "$(command -v helm)" ]; then
  echo -e 'Error: helm is not installed'
  exit 1
fi

if ! [ -x "$(command -v kubectl)" ]; then
  echo -e 'Error: kubectl is not installed'
  exit 1
fi

if ! [ -x "$(command -v docker)" ]; then
  echo 'Error: docker is not installed. \nwget https://docs.docker.com/install/linux/docker-ce/ubuntu/#install-docker-engine---community'
  exit 1
fi
make_or_remove_dir $INSTALL_DIR
cd $INSTALL_DIR
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