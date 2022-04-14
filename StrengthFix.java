package me.lowynzx.lowcx.core.utilities.fixes;

import me.lowynzx.lowcx.core.LowCore;
import me.lowynzx.lowcx.core.utilities.LowUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StrengthFix extends LowUtils implements Listener {

    protected LowCore core;

    @EventHandler
    public void fixMain(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player){
            Player p = (Player) e.getDamager();
            if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)){
                for (PotionEffect efectos : p.getActivePotionEffects()){
                    if (efectos.getType().equals(PotionEffectType.INCREASE_DAMAGE)){
                        int NewDamage;
                        double DamagePercent = (efectos.getAmplifier() + 1) * 1.3D * 1.0D;
                        if (e.getDamage() / DamagePercent <= 1.0D){
                            NewDamage = (efectos.getAmplifier() +1 ) * 3 + 1;
                        } else {
                            NewDamage = (int)(e.getDamage() / DamagePercent) + (efectos.getAmplifier() +1 ) * 3;
                        }
                        e.setDamage(NewDamage);
                        break;
                    }
                }
            }
        }
    }
}
