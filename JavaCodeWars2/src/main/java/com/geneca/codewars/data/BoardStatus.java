package com.geneca.codewars.data;

import java.util.List;

/**
 * Dummy object to represent the status of a game
 */
public class BoardStatus {
	
    public int RoundNumber;
    public int ActiveVesselCount;
    public List<TeamVesselInformation> VesselCountPerTeamId;
    public int SunkVesselCount;
    public Coordinate BoardMinCoordinate;
    public Coordinate BoardMaxCoordinate;
    public int TurnsUntilBoardShrink;
    public boolean ClusterMissleIsOnGameBoard;
    public Coordinate ClusterMissleLocation;

    // Player specific properties
    public List<Coordinate> HitCoordinates;
    public List<Coordinate> MissCoordinates;
    public List<VesselStatus> MyVesselStatuses;
    public List<PowerUpType> MyPowerUps;
    public int MyTeamId;

    // Truce specific properties
    public List<Integer> TruceOfferedBy;
    public List<Truce> ActiveTruces;
    public List<Coordinate> CoordinatesFromTruces;
    public List<Coordinate> CoordinatesOfAllies;
    public List<VesselStatus> SonarReportsOfAllies;

}