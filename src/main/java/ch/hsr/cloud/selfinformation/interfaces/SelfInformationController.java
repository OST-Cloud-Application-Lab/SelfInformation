package ch.hsr.cloud.selfinformation.interfaces;

import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.hsr.cloud.selfinformation.providers.EnvironmentVariables;
import ch.hsr.cloud.selfinformation.providers.HardwareInformation;
import ch.hsr.cloud.selfinformation.providers.InformationProvider;
import ch.hsr.cloud.selfinformation.providers.NetworkInformation;
import ch.hsr.cloud.selfinformation.providers.SystemInformation;

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