-- liquibase formatted sql
-- changeset ismyburguer:3

delete from item_pedido;
commit;
delete from pedido;
commit;

INSERT INTO pedido
(valor_total, cliente_id, pedido_id, status_pedido)
VALUES(86.00, NULL, 'dbdc211a-83a5-4944-b89e-f16ac7986708'::uuid, 'ABERTO');

INSERT INTO item_pedido
(preco, quantidade, valor_total, item_pedido_id, pedido_id, produto_id)
VALUES(5.50, 10, 55.00, 'c1f0cc89-e968-4b6e-a19a-26b8fd840b82'::uuid, 'dbdc211a-83a5-4944-b89e-f16ac7986708'::uuid, 'a1ca74a4-fdd5-4fcc-9ac9-0e35475e030e'::uuid);
INSERT INTO item_pedido
(preco, quantidade, valor_total, item_pedido_id, pedido_id, produto_id)
VALUES(15.50, 2, 31.00, '625eae7b-9ca4-4e34-9c77-508f91c6d316'::uuid, 'dbdc211a-83a5-4944-b89e-f16ac7986708'::uuid, 'beab006c-6ab3-4c42-b526-10e686802771'::uuid);