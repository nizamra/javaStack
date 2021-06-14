class ProjectTest {
    public static void main(String[] args){
        Project omarpro = new Project("project name only");
        Project omarpro2 = new Project("project name", "and proj desc");

        System.out.println(omarpro.elevatorPitch());

        omarpro.setterName("Main Anime");

        String OmarNew= omarpro.getterName();
        System.out.println(OmarNew);
    }
}