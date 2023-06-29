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
    stage('Step 1') {
      steps {
        echo "привет СБЕР, меня зовут ${ФИО} и я хочу у вас работать"
        sh 'echo "привет СБЕР, меня зовут ${ФИО} и я хочу у вас работать"'
      }
    }
    stage('Step 2') {
      steps {
        string(description: 'Поле ввода ФИО', name: 'ФИО', defaultValue: 'Выдрин Сергей Евгеньевич')
        echo "Привет СБЕР, меня зовут ${P_N}"
      }
    }
  }
  post {
      always {
        echo 'post'
      }
  }
}