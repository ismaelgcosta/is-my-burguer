-- liquibase formatted sql
-- changeset ismyburguer:4

create table controle_pedido (
    fim_da_preparacao timestamp(6),
    inicio_da_preparacao timestamp(6),
    recebido_em timestamp(6),
    controle_pedido_id uuid not null,
    pedido_id uuid references pedido(pedido_id),
    status_controle_pedido varchar(255) check (status_controle_pedido in ('AGUARDANDO_CONFIRMACAO','NAO_AUTORIZADO','PAGO')),
  primary key (controle_pedido_id))