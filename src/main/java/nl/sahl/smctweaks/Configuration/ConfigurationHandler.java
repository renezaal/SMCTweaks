package nl.sahl.smctweaks.Configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{

    public static void init(File configFile)
    {
        // Create the configuration object from the configuration file
        Configuration configuration = new Configuration(configFile);

        boolean alphaFireSpread = true;
        boolean farmlandNeedsSky = true;
        boolean simplePhysicsEnabled = true;
        boolean plantsNeedSky = true;

        try {
            // Load the configuration file
            configuration.load();

            // Read in the properties from the configuration file
            alphaFireSpread = configuration.get("Vanilla tweaks", "alphaFireSpread", false, "Make fire spread infinitely again").getBoolean(false);
            simplePhysicsEnabled = configuration.get("Vanilla tweaks", "simplePhysics", false, "Weak blocks will fall without proper support").getBoolean(false);
            farmlandNeedsSky = configuration.get("Vanilla tweaks", "farmLandNeedsSky", false, "Make farmland revert to dirt if it has no access to the sky").getBoolean(false);
            alphaFireSpread = configuration.get("Vanilla tweaks", "plantsNeedSky", false, "Prevent plants from growing if they have no access to the sky.\nThis does not apply to mushrooms or plants from mods").getBoolean(false);
        } catch (Exception e) {
            // Log the exception
        } finally {
            //Save the configuration file
            configuration.save();
        }
    }
}
