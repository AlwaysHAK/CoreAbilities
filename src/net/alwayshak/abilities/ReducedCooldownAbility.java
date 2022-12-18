package net.alwayshak.abilities;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;


public class ReducedCooldownAbility
        extends Ability {
    public ReducedCooldownAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("d85b3b8b-4b2e-4a55-b1d7-0bd8bf03dc8d"));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
            setAttackSpeed(e.getPlayer(), 6.0D);
        } else {
            setAttackSpeed(e.getPlayer(), 4.0D);
        }
    }

    private void setAttackSpeed(Player player, double attackSpeed) {
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        if (attribute == null)
            return;
        double baseValue = attribute.getBaseValue();
        if (baseValue != attackSpeed) {
            attribute.setBaseValue(attackSpeed);
            player.saveData();
        }
    }
}
