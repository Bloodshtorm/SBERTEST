echo "Hello, i am junior, remember it's please..."
//Создать в Jenkins джобу и написать скрипт для неё (декларативный groovy pipeline скрипт):
pipeline {
  agent any
  
  environment{
    P_N = "trash"
  }
//Параметры для запуска джобы
//Поле ввода ФИО
//Поле ввода почты e-mail
//Поле ввода слейва на котором выполнится задание
  parameters {
    string(description: 'Поле ввода ФИО', name: 'ФИО', defaultValue: 'Выдрин Сергей Евгеньевич')
    string(description: 'Поле ввода почты e-mail', name: 'Email', defaultValue: 'seryi01.vydrin@yandex.ru')
    string(description: 'Поле ввода слейва на котором выполнится задание(псевдовыбор)', name: 'Slave', defaultValue: 'Example 1')
  }
  //Первый стейдж: вывод в лог эхо «привет СБЕР, меня зовут «ФИО» и я хочу у вас работать»
  stages {
    stage('stage1') {
      steps {
        echo "привет СБЕР, меня зовут ${ФИО} и я хочу у вас работать"
      }
    }
    //Второй стейдж апррув: – должно появиться окно ввода «принять на работу»/«отказать»
    stage('stage2') {
        // no agent, so executors are not used up when waiting for approvals
        agent none
        steps {
            script {
                def ApprovalDelay = input id: 'Deploy', message: 'Форму запроса, выберите один из вариантов', parameters: [choice(choices: ['принять на работу', 'отказать'], description: 'Каково ваше решение?', name: 'Принять на работу или отказать?')]
                echo ApprovalDelay.toString()
            }
        }
    }
    stage('stage3') {
        steps {
            script {
                echo ApprovalDelay.toString()
            }
        }
    }
  }
  post {
    always {
    echo 'post'
    }
  }
}