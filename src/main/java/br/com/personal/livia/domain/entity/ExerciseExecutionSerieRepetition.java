package br.com.personal.livia.domain.entity;

public class ExerciseExecutionSerieRepetition extends ExerciseExecution {

    int serie;
    int repetition;

    public ExerciseExecutionSerieRepetition(int rest, int serie, int repetition) {
        super(rest);
        this.serie = serie;
        this.repetition = repetition;
    }
}
