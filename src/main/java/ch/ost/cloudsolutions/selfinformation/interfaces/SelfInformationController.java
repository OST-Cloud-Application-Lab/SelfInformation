package ch.ost.cloudsolutions.selfinformation.interfaces;

import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.ost.cloudsolutions.selfinformation.providers.EnvironmentVariables;
import ch.ost.cloudsolutions.selfinformation.providers.HardwareInformation;
import ch.ost.cloudsolutions.selfinformation.providers.InformationProvider;
import ch.ost.cloudsolutions.selfinformation.providers.NetworkInformation;
import ch.ost.cloudsolutions.selfinformation.providers.SystemInformation;

@Controller
public class SelfInformationController {

	@GetMapping("/")
	public String getSelfInformation(Model model) throws SocketException {

		List<InformationProvider> providers = Arrays.asList(new HardwareInformation(), new NetworkInformation(),
				new SystemInformation(), new EnvironmentVariables());

		model.addAttribute("informationProviders", providers);

		return "index";
	}
}