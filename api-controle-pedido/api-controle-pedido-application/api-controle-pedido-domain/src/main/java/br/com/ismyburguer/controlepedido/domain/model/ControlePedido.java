package br.com.ismyburguer.controlepedido.domain.model;

import br.com.ismyburguer.core.exception.BusinessException;
import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ControlePedido implements Validation {

    private ControlePedidoId controlePedidoId;

    @NotNull(message = "Informe o código do Pedido")
    private PedidoId pedidoId;

    private StatusControlePedido statusControlePedido = StatusControlePedido.RECEBIDO;

    private LocalDateTime recebidoEm = LocalDateTime.now();

    private LocalDateTime inicioDaPreparacao;
    private LocalDateTime fimDaPreparacao;

    public ControlePedido(PedidoId pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void emPreparacao() {
        StatusControlePedido proximo = StatusControlePedido.EM_PREPARACAO;
        statusControlePedido.validarProximoStatus(proximo);
        statusControlePedido = proximo;
        inicioDaPreparacao = LocalDateTime.now();
    }

    public void pronto() {
        StatusControlePedido proximo = StatusControlePedido.PRONTO;
        statusControlePedido.validarProximoStatus(proximo);
        statusControlePedido = proximo;
        fimDaPreparacao = LocalDateTime.now();
    }
    public void retirado() {
        statusControlePedido = StatusControlePedido.RETIRADO;
    }

    @Getter
    public enum StatusControlePedido {

        RECEBIDO("Recebido"),
        EM_PREPARACAO("Em Preparação"),
        PRONTO("Pronto"),
        RETIRADO("Retirado");

        private final String descricao;

        StatusControlePedido(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }

        public void validarProximoStatus(StatusControlePedido statusPedido) {
            String message = "O Pedido precisa estar com o Status " + getDescricao() + " para poder ser alterado para " + statusPedido.getDescricao();

            if(statusPedido == EM_PREPARACAO && this != RECEBIDO) {
                throw new BusinessException(message);
            }

            if(statusPedido == PRONTO && this != EM_PREPARACAO) {
                throw new BusinessException(message);
            }
        }

    }

    @Getter
    @AllArgsConstructor
    public static class PedidoId {

        @NotNull(message = "Informe o código do Pedido")
        private UUID pedidoId;

        public PedidoId(String pedidoId) {
            this.pedidoId = UUID.fromString(pedidoId);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ControlePedidoId {

        @NotNull(message = "Informe o código de Controle do Pedido")
        private UUID controlePedidoId;

    }

    public Optional<ControlePedidoId> getControlePedidoId() {
        return Optional.ofNullable(controlePedidoId);
    }
}
