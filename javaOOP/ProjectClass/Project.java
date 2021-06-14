class Project{
    String name;
    String description;

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name){
        this.name = name;
    }

    public String elevatorPitch(){

        return this.name+ " , "+ this.description;
    }

    // Create getter and setters for each field
    public String getterName(){
        return this.name;
    }
    public void setterName(String name){
        this.name = name;
    }
}