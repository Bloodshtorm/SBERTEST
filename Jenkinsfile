echo "Hello, i am junior, remember it's please..."
pipeline {
  
  agent any
  
  environment{
    P_N = "trash"
  }
  parameters {
    string(description: 'Parameter', name: 'PARAMETER_VARIABLE', defaultValue: 'ParameterTEST')
  }

  stages {
    stage('Step 1') {
      steps {
        echo 'Привет СБЕР, ${P_N} ${Parameter}'
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