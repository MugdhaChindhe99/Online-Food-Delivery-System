package online.food.delivery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.cg.ofd.bean.Category;
import com.cg.ofd.service.CategoryService;
import com.cg.ofd.service.CategoryServiceImpl;

class CategoryTest {

	@Test
	void testAddCategory() {
		Category cat = new Category(16,"icecream2");
		CategoryService catservice = mock(CategoryServiceImpl.class);
		when(catservice.addCategory(cat)).thenReturn(cat);
		
		Category c2 = catservice.addCategory(cat);
		assertEquals(cat, c2);
	}
	
	 @Test
	    public void findOneCategory()
	    {
		 Category cat = new Category(17,"icecream2");
		 CategoryService catservice = mock(CategoryServiceImpl.class);
		 catservice.addCategory(cat);
		 
	        when(catservice.findOneCategory(17)).thenReturn(cat);
	         Category c1 =catservice.findOneCategory(17);
	        
	        assertEquals("icecream2",c1.getCategoryName());
	      
	    }

	 @Test
	 public void removeCategory()
	 {
		 Category cat = new Category(16,"icecream2");
		 CategoryService catservice = mock(CategoryServiceImpl.class);
		 catservice.addCategory(cat);
		 
		 when(catservice.deleteCategory(16)).thenReturn(Boolean.TRUE);
		 Boolean cat2=catservice.deleteCategory(16);
			assertEquals(Boolean.TRUE, cat2);
	 }
	 
	 @Test
		public void updateCategory()  {
		 Category cat = new Category(17,"icecream2");
		 CategoryService catservice = mock(CategoryServiceImpl.class);
		 catservice.addCategory(cat);
		 Category cat2 = new Category(17,"burger");	
		 
		 when(catservice.updateCategory(cat2)).thenReturn(cat2);
		
		Category cat3=catservice.updateCategory(cat2);
		assertEquals(cat2, cat3);
		}
	

}
