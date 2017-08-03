package com.minecraftmod.tutorial;

public class Reference {

    public static final String MOD_ID = "carmechmod";
    public static final String NAME = "Car Mechanic ITE";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSION = "";

    public static final String  CLIENT_PROXY_CLASS ="com.minecraftmod.tutorial.proxy.ClientProxy";
    public static final String  SERVER_PROXY_CLASS ="com.minecraftmod.tutorial.proxy.ServerProxy";

    public static enum MechItems{
        RADIATOR("radiator","ItemRadiator"),
        NUT("nut","ItemNut"),
        BOLT("bolt","ItemBolt"),
        POTION_JUMP_BOOST("potionjumpboost","PotionJumpBoost");

        private String unlocalizedName;
        private String registryName;

        MechItems(String unlocalizedName,String registryName){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getRegistryName() {
            return registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
    }

    public static enum MechBlocks{
        ENGINEBLOCK("engineBlock","BlockEngineBlock"),
        COMBUSTIONENGINE("combustionEngine","BlockCombustionEngine"),
        TEST("test","TestBlock");

        private String unlocalizedName;
        private String registryName;

        MechBlocks(String unlocalizedName,String registryName){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getRegistryName() {
            return registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
    }
}
