# Cloud related information

This repository contains information related to cloud native applications and tech used.

## AWS-CLI

- Below are the steps to install aws cli:

```
sudo su
cd /
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

### AWS Configuration:

```
aws configure (with and without --profile) 
or
aws configure import --csv file://path/to/creds.csv
do aws configure wizard ----> help

complete -C aws_completer aws  --> for auto tab completion
cli_auto_prompt = on ---> append this in .aws/config file for interactive mode.
```
