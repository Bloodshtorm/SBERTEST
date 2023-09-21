echo "Hello, i am junior, remember it's please..."
//Создать в Jenkins джобу и написать скрипт для неё (декларативный groovy pipeline скрипт):
pipeline {
  agent any
  
  environment{
    RESULT_APPROVAL = null
  }
//Параметры для запуска джобы
//Поле ввода ФИО
//Поле ввода почты e-mail
//Поле ввода слейва на котором выполнится задание
  parameters {
    string(description: 'Поле ввода ФИО', name: 'ФИО', defaultValue: 'Выдрин Сергей Евгеньевич')
    string(description: 'Поле ввода почты e-mail', name: 'EMAIL', defaultValue: 'seryi01.vydrin@yandex.ru')
    string(description: 'Поле ввода слейва на котором выполнится задание(псевдовыбор)', name: 'SlAVE', defaultValue: 'standalone_builder')
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
            if (ApprovalDelay.toString() == 'принять на работу') {
              //По флагу «принять на работу» должно пойти дальше на следующий стейдж
              $RESULT_APPROVAL="${ФИО} принят"
            } else {
              //По флагу «отказать» должно завершить работу джобы и повесить на билд бейдж о том, что кандидату «ФИО» отказано
              script {
                $RESULT_APPROVAL = "кандидату ${ФИО} отказано"
                currentBuild.displayName = $RESULT_APPROVAL
                currentBuild.result = 'ABORTED'
                error("$RESULT_APPROVAL")
                return
              }
            }
          }
        }
    }
    //Третий стейдж – отправить письмо на «e-mail» с уведомлением. Текст: «ФИО» принят.
    stage('stage3') {
      steps {
        //script {
          echo "${ФИО} вам сообщение от СБЕРА"
          //не знаю как иначе это реализовать, пока вот так:
          //mail to: "${EMAIL}", subject: "${ФИО} вам сообщение от СБЕРА", body: "${ФИО} принят"
        //}
      }
    }
  }
  post {
    always {
    echo 'Done!'
    }
  }
}