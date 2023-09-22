
# Serviço de Envio de Emails com Java Spring e Amazon SES

Este é um serviço de envio de emails desenvolvido em Java Spring que utiliza o Amazon SES para enviar emails de forma confiável e escalável.
## Pré-requisitos

Antes de começar a usar este serviço, você precisará ter o seguinte configurado:

* Conta na Amazon Web Services (AWS) com permissões para usar o Amazon SES.
* JDK (Java Development Kit) instalado na sua máquina.
* Maven instalado para gerenciar as dependências do projeto.
* Um ambiente de desenvolvimento Java, como Eclipse ou IntelliJ IDEA, ou qualquer IDE de sua escolha.


## Configuração

1. Clone este repositório para a sua máquina:
```bash
  git clone https://github.com/seu-usuario/seu-projeto.git
```
2. Abra o projeto na sua IDE e configure as credenciais da AWS no arquivo application.properties ou application.yml. Certifique-se de definir as seguintes propriedades:
```bash
aws.accessKeyId=SUACHAVEDEACESSO
aws.secretKey=SUASENHADEACESSO
aws.region: REGIAOAWS
```
    
## Uso

Agora que o projeto está configurado, você pode começar a usar o serviço de envio de emails. Para enviar um email, faça uma requisição POST para o seguinte endpoint:
```bash
POST http://localhost:8080/api/email
```
Use o seguinte payload JSON como exemplo:
```json
{
	"to": "kaykiletieri37@gmail.com",
	"subject": "Assunto",
	"body": "Corpo do email"
}

```

