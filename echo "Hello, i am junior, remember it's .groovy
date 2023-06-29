echo "Hello, i am junior, remember it's please..."
pipeline {
  
  agent any
  
  enviroment{
    P_N = "trash"
  }

  stages {
    stage('Step 1') {
      steps {
        echo 'Привет СБЕР, меня зовут "$FIO" ${P_N}'
      }
    }
    stage('Step 2') {
      steps {
        echo 'Привет СБЕР, меня зовут "${FIO}"'
      }
    }
  }
  post {
      always {
        echo 'post'
      }
  }
}