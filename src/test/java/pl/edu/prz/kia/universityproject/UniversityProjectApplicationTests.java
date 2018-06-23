package pl.edu.prz.kia.universityproject;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.prz.kia.universityproject.controller.HomeController;
import pl.edu.prz.kia.universityproject.controller.LoginController;
import pl.edu.prz.kia.universityproject.model.Specialization;
import pl.edu.prz.kia.universityproject.model.User;
import pl.edu.prz.kia.universityproject.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversityProjectApplicationTests {

	@Test
	public void contextLoads() throws Exception {

		UserService mockUserService = new UserService() {
			@Override
			public User findUserByEmail(String email) {
				return null;
			}
			
			@Override
			public User getOne(Long id) {
				return null;
			}

			@Override
			public void saveUser(User user) {

			}
      
      			@Override
      			public void saveUserActivation(User user) {

      			}

			@Override
			public void calculateSurveyResults(List<Specialization> specializations, User user) {

			}

			@Override
			public List<User> findAll() {
				return null;
			}

			@Override
			public void deleteUser(Long userId) {
			}
		};
		//HomeController homeController = new HomeController();
		LoginController loginController = new LoginController(mockUserService);
		//ModelAndView mav = homeController.index();
		//Assert.assertNotNull(homeController);
		Assert.assertNotNull(loginController);
		//Assert.assertEquals("index", mav.getViewName());
		//mav = loginController.login();
		//Assert.assertEquals("login", mav.getViewName());
		//mav = loginController.registration();
		//Assert.assertEquals("registration", mav.getViewName());
		//simplest possible tests
		//to see how they work, change expected values to sth else
	}

}
