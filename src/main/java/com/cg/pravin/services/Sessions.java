package com.cg.pravin.services;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pravin.modal.Employee;
import com.cg.pravin.repository.EmployeeRepository;

@Service
public class Sessions {
	
	@Autowired
	private EmployeeRepository emprepo;

	// login session
	public static void setLoginStatus(Employee emp) {
		emp.setLogged(true);
		emp.setConfirmationToken(generateRandomHexToken(32));
	}
	
	// logout session
	public static void setLogoutStatus(Employee emp) {
		emp.setLogged(false);
		emp.setConfirmationToken(null);
	}

//========================================================================
	
	public int autoIdGenerator() {
		//Id generator
		int baseId = 10000;
		int len = 0;
		int newEmpId = 0;
		List<Employee> list = null;
		
		try {
			list = emprepo.findAll()  ;
			len = list.size();
		}catch(Exception ee){
			len = 0;
		}
		
		if(len != 0) {
			Employee lastuser = list.get(len-1);
			System.out.println(lastuser);
			int lastId = lastuser.getEmpId();
			System.out.println(lastId);
			newEmpId = lastId + 1;
			System.out.println(newEmpId);
		}else {
			newEmpId = baseId + 1;
		}
		
		return newEmpId;
	}
	

// =============================================================================
	
	// Hexadecimal Token Generator
	public static String generateRandomHexToken(int byteLength) {
		SecureRandom secureRandom = new SecureRandom();
		byte[] token = new byte[byteLength];
		secureRandom.nextBytes(token);
		return new BigInteger(1, token).toString(16); // Hexadecimal encoding
	}

// =============================================================================
	
	// Token generator - Java 8 Supplier
	public static Stream<String> Token() {
		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			// currentTimeInMilisecond + random code
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID().toString()).toString();
		};

		return Stream.generate(tokenSupplier).limit(1);

	}

// =============================================================================
	
	private static final SecureRandom secureRandom = new SecureRandom();
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

	// Token generator - Java 8 Base64
	public static String getToken() {
		byte[] randomBytes = new byte[32];
		secureRandom.nextBytes(randomBytes);
		return base64Encoder.encodeToString(randomBytes);
	}

}





// Testing
//public static void main(String[] args) {
//Token().forEach(System.out::println);
//System.out.println(getToken());
//System.out.println(generateRandomHexToken(32));
//}
