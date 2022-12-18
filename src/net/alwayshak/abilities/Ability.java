package net.alwayshak.abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class Ability implements Listener {
    private final String name;
    private final String description;
    private final List<UUID> members;
    private Class event;

    public Ability(String name, String description) {
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>();
    }

    public Ability(String name, String description, List<UUID> members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<UUID> getMembers() {
        return this.members;
    }

    public void addMember(UUID uuid) {
        this.members.add(uuid);
    }

    public void addMember(Player p) {
        this.members.add(p.getUniqueId());
    }

    public void removeMember(UUID uuid) {
        this.members.remove(uuid);
    }

    public void removeMember(Player p) {
        this.members.remove(p.getUniqueId());
    }
}