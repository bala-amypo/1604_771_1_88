@GetMapping
public List<Facility> getAllFacilities() {
    return facilityService.getAll();
}
