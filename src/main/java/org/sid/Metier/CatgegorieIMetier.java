package org.sid.Metier;

import org.sid.entites.Category;

public interface CatgegorieIMetier {
    public void SaveCategory(Category catgeory);
    public Category GetCatgorrybyId(String id);
}
