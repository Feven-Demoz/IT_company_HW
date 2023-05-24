package enums;

public enum ProgramingLanguages {
    JAVA("Java"),
    PYTHON("Python"),
    JAVASCRIPT("JavaScript"),
    SQL("SQL"),
    C_PLUS_PLUS("C++");



private final String languages;

    ProgramingLanguages(String languagesEnter) {
        this.languages = languagesEnter;
    }

    public String getLanguages() {
        return languages;
    }
}
