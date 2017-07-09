public abstract class Part {
    //Attributes OK!
    private String id;
    private String name;

    //Methods OK!
    public Part(String id, String name) throws NullPointerException, IllegalArgumentException {
        if(id == null || name == null) throw new NullPointerException();
        if(id == "" || name == "") throw new IllegalArgumentException();
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
}
