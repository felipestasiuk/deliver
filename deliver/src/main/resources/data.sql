DROP TABLE IF EXISTS conta;

CREATE TABLE conta (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(250),
  valor NUMERIC(9,2),
  juros_dia NUMERIC(9,2),
  calculo VARCHAR(50),
  vencimento DATETIME2,
  pagamento DATETIME2
);

DROP SEQUENCE IF EXISTS conta_seq;


-- INSERT
--   INTO conta(nome, valor, juros_dia, calculo, vencimento, pagamento)
--   VALUES('Luz', 90.50, 90.50, 'sem juros', '2020-02-10 00:00:00', '2020-02-10 00:00:00');

