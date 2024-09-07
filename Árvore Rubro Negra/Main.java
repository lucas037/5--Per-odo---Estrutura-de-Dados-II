class Main {
    public static void main(String[] args) {
        ArvRN arv = new ArvRN(30);

        arv.insert(13);
        arv.insert(53);

        arv.insert(8);
        arv.insert(23);
        arv.insert(43);
        arv.insert(83);

        arv.insert(63);
        arv.insert(93);

        //arv.insert(91);

        System.out.println("\n"+arv);
    }
}