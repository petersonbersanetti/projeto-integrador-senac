CREATE TABLE users (
  id_registro BIGINT(20) NOT NULL AUTO_INCREMENT,
  tx_nome_razao_social VARCHAR(100) NOT NULL,
  tx_cpf_cnpj CHAR(11) NOT NULL,
  tx_endereco VARCHAR(100) NOT NULL,
  tx_telefone VARCHAR(15) NOT NULL,
  tx_email VARCHAR(100) NOT NULL,
  tx_senha VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_registro`));
