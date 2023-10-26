-- liquibase formatted sql
-- changeset ismyburguer:2
delete from item_pedido;
commit;
delete from produto;
commit;

INSERT INTO produto (ativo, preco, produto_id, categoria, descricao)
VALUES(true, 12.50, '298d1869-2051-40d4-a103-02f1c73be0a6'::uuid, 'LANCHE', 'Novo Lanche Monstro');

INSERT INTO produto (ativo, preco, produto_id, categoria, descricao)
VALUES(true, 2.50, '5fea5494-c231-4362-8432-9936bbc8af45'::uuid, 'SOBREMESA', 'Novo Mousse de Chocolate');

INSERT INTO produto (ativo, preco, produto_id, categoria, descricao)
VALUES(true, 6.50, '1e0cf10d-660b-4c75-b175-9393b184518e'::uuid, 'BEBIDA', 'Energy Drink');

INSERT INTO produto (ativo, preco, produto_id, categoria, descricao)
VALUES(true, 5.50, 'a1ca74a4-fdd5-4fcc-9ac9-0e35475e030e'::uuid, 'BEBIDA', 'Energy Drink Uva');

INSERT INTO produto (ativo, preco, produto_id, categoria, descricao)
VALUES(true, 3.50, '550858dd-bf71-44fc-9eb0-dd38f22d079a'::uuid, 'SOBREMESA', 'Sunday de Morango');

INSERT INTO produto (ativo, preco, produto_id, categoria, descricao)
VALUES(true, 15.50, 'beab006c-6ab3-4c42-b526-10e686802771'::uuid, 'LANCHE', 'X-Tudão');

