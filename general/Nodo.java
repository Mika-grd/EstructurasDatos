public class Nodo <T> {
    public T valor;
    public Nodo<T> proxmo;

    public Nodo(T valor){
        this.valor = valor;
        proxmo = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getProxmo() {
        return proxmo;
    }

    public void setProxmo(Nodo<T> proxmo) {
        this.proxmo = proxmo;
    }

    @Override
    public String toString() {
        return "Nodo [valor=" + valor + ", proxmo=" + proxmo + "]";
    }
    

    
}
