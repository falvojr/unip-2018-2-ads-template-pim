package br.unip.ads.pim.utils;

public class ExcecaoNegocial extends RuntimeException {

	private static final long serialVersionUID = -4315266357119652874L;

	public ExcecaoNegocial(String mensagem) {
		super(mensagem);
	}
}
