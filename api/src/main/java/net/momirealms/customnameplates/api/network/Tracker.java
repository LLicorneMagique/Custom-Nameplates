package net.momirealms.customnameplates.api.network;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.momirealms.customnameplates.api.CNPlayer;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents a tracker for a specific player. This class stores and manages the state of the player
 * being tracked, including their crouching status, scale, spectator status, and passengers.
 */
public class Tracker {
    private boolean isCrouching;
    private double scale;
    private boolean isSpectator;
    private final CNPlayer tracker;
    private final CopyOnWriteArrayList<Integer> passengerIDs = new CopyOnWriteArrayList<>();

    /**
     * Constructs a new Tracker
     *
     * @param tracker the tracker who is tracking the player
     */
    public Tracker(CNPlayer tracker) {
        if (tracker == null) {
            throw new IllegalArgumentException("Tracker cannot be null");
        }
        this.isCrouching = false;
        this.scale = 1;
        this.tracker = tracker;
    }

    /**
     * Retrieves the tracker
     *
     * @return the tracker
     */
    public CNPlayer tracker() {
        if (tracker == null) {
            throw new IllegalStateException("Tracker is not initialized");
        }
        return tracker;
    }

    /**
     * Checks if the tracked player is currently crouching.
     *
     * @return true if the player is crouching, false otherwise
     */
    public boolean isCrouching() {
        return isCrouching;
    }

    /**
     * Sets the crouching status for the tracked player.
     *
     * @param crouching the new crouching status
     */
    public void setCrouching(boolean crouching) {
        isCrouching = crouching;
    }

    /**
     * Checks if the tracked player is in spectator mode.
     *
     * @return true if the player is a spectator, false otherwise
     */
    public boolean isSpectator() {
        return isSpectator;
    }

    /**
     * Sets the spectator status for the tracked player.
     *
     * @param spectator the new spectator status
     */
    public void setSpectator(boolean spectator) {
        isSpectator = spectator;
    }

    /**
     * Retrieves the current scale of the tracked player.
     *
     * @return the scale of the player
     */
    public double getScale() {
        return scale;
    }

    /**
     * Sets the scale for the tracked player.
     *
     * @param scale the new scale value
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    /**
     * Adds a passenger ID to the list of passengers attached to the tracked player.
     *
     * @param passengerID the ID of the passenger to add
     */
    public void addPassengerID(int passengerID) {
        this.passengerIDs.add(passengerID);
    }

    /**
     * Removes a passenger ID from the list of passengers attached to the tracked player.
     *
     * @param passengerID the ID of the passenger to remove
     */
    public void removePassengerID(int passengerID) {
        this.passengerIDs.remove((Object) passengerID);
    }

    /**
     * Retrieves the set of passenger IDs attached to the tracked player.
     *
     * @return a set of passenger IDs
     */
    public Set<Integer> getPassengerIDs() {
        return new ObjectOpenHashSet<>(passengerIDs);
    }

    /**
     * Checks if the tracked player has no passengers attached.
     *
     * @return true if the player has no passengers, false otherwise
     */
    public boolean isEmpty() {
        return passengerIDs.isEmpty();
    }
}