def secrets = [
  [path: 'ebpm/eBPM/PoC', engineVersion: 2, secretValues: [
    [envVar: 'DB_HOST', vaultKey: 'DB_HOST']]],
]

def configuration = [vaultUrl: 'https://vault-ha-prod.apps.esp04.sac.flex.com',  
    vaultCredentialId: '82fd7dd0-c70d-428b-a27e-35f5b35fd873', engineVersion: 2]

pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        disableConcurrentBuilds()
    }
    stages{   
     
      stage('Checkout'){
          steps{
              sh "rm -r vault-poc"
              sh "git clone https://github.com/hemashekarsantosh/vault-poc.git"
              sh "chmod -R 777 vault-poc"
          }
      }
      stage('Compile'){
          steps{
              dir('vault-poc'){
                  sh "pwd"
                  sh "javac EnvironmentVariableExample.java"
              }
          }
      }
      stage('Execute'){
          steps{
              dir('vault-poc'){
                  withVault([configuration: configuration, vaultSecrets: secrets]) {
                        sh "java EnvironmentVariableExample"
                     }
                 }
          }
      }
    }
}
