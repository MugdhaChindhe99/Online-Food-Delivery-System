package online.food.delivery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cg.ofd.bean.Address;
import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.dao.ItemRepository;
import com.cg.ofd.service.CategoryService;
import com.cg.ofd.service.CategoryServiceImpl;
import com.cg.ofd.service.ItemService;
import com.cg.ofd.service.ItemServiceImpl;

class ItemsTest {

	@Test
	void testAddItems() {
		Category cat = new Category(16,"icecream2");
		Address address= new Address(530,"gopalpatti","lane3","hadapsar","pune","ms","india","555555");
		
		List<Restaurant> restro = new ArrayList<>(); 
		Restaurant r1=new Restaurant(100009,"KFC",address,"Sulekha","9898989898");
		restro.add(r1);

	    
		Items item = new Items(114,"item6",cat,45,60,restro);
		ItemService itemservice = mock(ItemServiceImpl.class);
		when(itemservice.addItem(item)).thenReturn(item);
		
		Items item2 = itemservice.addItem(item);
		assertEquals(item,item2);
		
	}
	
	@Test
	void findAllItems()
	{
		Category cat = new Category(16,"icecream2");
		Category cat2 = new Category(17,"icecream3");

		List<Items> item1 = new ArrayList<>(); 
		Items i1 = new Items(114,"item6",cat,45,60);
		Items i2 = new Items(115,"item7",cat,46,61);
		Items i3 = new Items(115,"item8",cat2,46,61);
		item1.add(i1);
		item1.add(i2);
		item1.add(i3);
		
		ItemService itemservice = mock(ItemServiceImpl.class);
		System.out.println(item1);
		
		when(itemservice.findAllItems()).thenReturn(item1);
		List<Items> item2 = itemservice.findAllItems();
		assertNotNull(item2);
		assertFalse(item2.isEmpty());
	}
	
	
	
}
