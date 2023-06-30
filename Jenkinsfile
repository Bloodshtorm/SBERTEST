echo "Hello, i am junior, remember it's please..."
pipeline {
  agent any
  
  environment{
    P_N = "trash"
  }
  parameters {
    string(description: 'Поле ввода ФИО', name: 'ФИО', defaultValue: 'Выдрин Сергей Евгеньевич')
    string(description: 'Поле ввода почты e-mail', name: 'Email', defaultValue: 'seryi01.vydrin@yandex.ru')
    string(description: 'Поле ввода слейва на котором выполнится задание(псевдовыбор)', name: 'Slave', defaultValue: 'Example 1')
  }


  stages {
    stage('stage1') {
      steps {
        echo "привет СБЕР, меня зовут ${ФИО} и я хочу у вас работать"
      }
    }
    stage('Approval') {
        // no agent, so executors are not used up when waiting for approvals
        agent none
        steps {
            script {
                def deploymentDelay = input id: 'Deploy', message: 'Deploy to production?', submitter: 'rkivisto,admin', parameters: [choice(choices: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'], description: 'Hours to delay deployment?', name: 'deploymentDelay')]
                sleep time: deploymentDelay.toInteger(), unit: 'HOURS'
            }
        }
    }
    stage('Deploy') {
        agent any
        steps {
            // uses https://plugins.jenkins.io/lockable-resources
            lock(resource: 'deployApplication'){
                echo 'Deploying...'
            }
        }
    }
    /*stage ('stage2') {
      steps {
        input{
        message "Принять на работу?"
        }
      }
    }*/
  }
  post {
    always {
    echo 'post'
    }
  }
}