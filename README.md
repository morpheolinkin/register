# Sistema de Matrícula de Alunos

Bem-vindo ao Sistema de Matrícula de Alunos! Este projeto, desenvolvido por Jefferson Medeiros da Silva, é parte do curso de Licenciatura em Ciências da Computação pelo Instituto Federal de Educação, Ciência e Tecnologia Baiano (IFBaiano) - Campus de Senhor do Bonfim.

## Descrição

O Sistema de Matrícula de Alunos é uma aplicação Java com SpringBoot, utilizando um banco de dados MySQL para armazenar informações sobre alunos, professores, turmas e disciplinas. 
Este sistema oferece uma solução completa para a gestão acadêmica, proporcionando uma interface intuitiva para cadastrar e acessar dados relevantes.

## Funcionalidades

- **Cadastro de Alunos:** Registre informações detalhadas sobre os alunos, incluindo nome, matrícula, curso e outros dados pertinentes.

- **Cadastro de Professores:** Mantenha um registro dos professores, incluindo nome, disciplinas ministradas e outras informações relevantes.

- **Cadastro de Turmas:** Gerencie turmas, atribuindo professores, disciplinas e alunos a cada uma delas.

- **Cadastro de Disciplinas:** Adicione informações sobre as disciplinas oferecidas, incluindo código, nome e carga horária.

## Configuração do Ambiente

Certifique-se de ter o Java e o Docker com o conteiner do MySQL instalados em sua máquina se quiser utilizar o banco do Mysql ou pode utilizar do perfil de `test` alterando apenas o arquivo `application.properties`. 
Clone este repositório e ajuste as configurações do banco de dados no arquivo `application.properties`. Execute o projeto utilizando o SpringBoot.

```bash
git clone https://github.com/morpheolinkin/register.git
cd register.git
./mvnw spring-boot:run
```

## Contato

Para mais informações ou dúvidas sobre o projeto, entre em contato com Jefferson Medeiros da Silva pelo e-mail: jeffersonmedeirosdasilva@gmail.com.

Sinta-se à vontade para contribuir, relatar problemas ou sugerir melhorias. Obrigado por utilizar o Sistema de Matrícula de Alunos! 🚀
