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
                def ApprovalDelay = input id: 'Deploy', message: 'принять на работу/отказать', parameters: [choice(choices: ['принять на работу', 'отказать'], description: 'Каково ваше решение?')]
                /*sleep time: ApprovalDelay.toString(), unit: 'Approv'*/
                echo ApprovalDelay.toString()
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