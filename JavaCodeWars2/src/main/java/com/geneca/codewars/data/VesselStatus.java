package com.geneca.codewars.data;

import java.util.ArrayList;
import java.util.List;

public class VesselStatus
{
    public VesselStatus()
    {
        Location = new ArrayList<Coordinate>();
        SonarReport = new ArrayList<Coordinate>();
        DamagedSections = new ArrayList<Boolean>();
        AllowedToFireTo = new ArrayList<Coordinate>();
        AllowedToMoveTo = new ArrayList<List<Coordinate>>();
    }

    public int Id;
    public int Health;
    public int MaxHealth;
    public int Size;
    public int CollisionPointsGiven;
    public int CollisionPointsReceived;
    public int MissileRange;
	public int SonarRange;
    public int CounterMeasures;
    public int MovesUntilRepair;
    public boolean CounterMeasuresLoaded;
    public boolean AllowRepair;

    public List<Coordinate> Location;
    public List<Coordinate> SonarReport;
    public List<Coordinate> AllowedToFireTo;
    public List<List<Coordinate>> AllowedToMoveTo;
    public List<Boolean> DamagedSections;
}