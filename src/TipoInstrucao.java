
public enum TipoInstrucao {

	AND(2147483647), OR(2147483646), XOR(2147483645), COM(2147483644), HALT(2147483643);

	private int tipoInstrucao;

	TipoInstrucao(int tipoInstrucao) {
		this.tipoInstrucao = tipoInstrucao;
	}

	public int getTipoInstrucao() {
		
		return this.tipoInstrucao;
	}
	

}
