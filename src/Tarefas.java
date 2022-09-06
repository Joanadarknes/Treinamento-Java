class Tarefa {
    private final String tarefa;

    // método construtor
    public Tarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    // método que "executa" o processo "tarefa"
    public void run() {
        System.out.println("Nome da tarefa: " + tarefa);
    }
}

public class Tarefas{
    public static void main(String[] args) {
        // Mono tarefa
        Tarefa tarefa1 = new Tarefa("Listar");
        //Multitarefa
        Tarefa tarefa2= new Tarefa("Atualizar");
        Tarefa tarefa3= new Tarefa("Excluir");
        // executar a tarefa criada
        tarefa1.run();
        tarefa2.run();
        tarefa3.run();
    }
}