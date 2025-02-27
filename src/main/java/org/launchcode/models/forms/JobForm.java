package org.launchcode.models.forms;

import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=2, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    /*
        TODO #3 - Included other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters
     */
    //Complete
    @NotNull
    private int locationId;
    @NotNull
    private int coreCompetencyId;
    @NotNull
    private int positionTypeId;

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view
        */
        //Complete

        employers = jobData.getEmployers().findAll();
        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    // Added getters and setters for #3
    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }

    public int getLocationId() { return locationId; }

    public void setLocationId(int locationId) { this.locationId = locationId; }

    public int getCoreCompetencyId() { return coreCompetencyId; }

    public void setCoreCompetencyId(int coreCompetencyId) { this.coreCompetencyId = coreCompetencyId; }

    public int getPositionTypeId() { return positionTypeId; }

    public void setPositionTypeId(int positionTypeId) { this.positionTypeId = positionTypeId; }

    public Employer findEmpById(int id) {
        for (Employer employer : getEmployers()) {
            if (employer.getId() == id)
                return employer;
        }
        return null;
    }

    public Location findLocById(int id) {
        for (Location location : getLocations()) {
            if (location.getId() == id)
                return location;
        }
        return null;
    }

    public PositionType findTypeById(int id) {
        for (PositionType position : getPositionTypes()) {
            if (position.getId() == id)
                return position;
        }
        return null;
    }

    public CoreCompetency findCoreById(int id) {
        for (CoreCompetency competency : getCoreCompetencies()) {
            if (competency.getId() == id)
                return competency;
        }
        return null;
    }
}
