echo "Hello, i am junior, remember it's please..."
pipeline {
  
  agent any
  
  environment{
    P_N = "trash"
  }

  stages {
    stage('Step 1') {
      steps {
        echo 'Привет СБЕР, ${P_N}'
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