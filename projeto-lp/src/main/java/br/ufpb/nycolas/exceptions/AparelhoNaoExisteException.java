package br.ufpb.nycolas.exceptions;

public class AparelhoNaoExisteException extends Exception{
    public AparelhoNaoExisteException(String msg) {
        super(msg);
    }

    public AparelhoNaoExisteException(String msg, Throwable cause){
        super(msg, cause);
    }
}
