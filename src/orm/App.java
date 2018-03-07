package orm;


import orm.vue.VueOrm;

public class App {

    public static void main(String[] parametres) {

        VueOrm vueOrm = new VueOrm();
        vueOrm.launch(VueOrm.class, parametres);


    }

}
