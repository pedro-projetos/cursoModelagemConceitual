package com.pedroartur.cursomc.domain.enums;

public enum EstadoPagamento {
	
	Pendente(1, "Pendente"),
	Quitado(2,"Quitado"),
	Cancelado(3,"Cancelado");
	
	private Integer codigo;
	private String descricao;
	
	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}

}
