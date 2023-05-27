package br.com.cod3r.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {
	
	void valorAlterado(String novoValor);

}
