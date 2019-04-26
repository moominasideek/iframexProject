package com.baabbee.iframex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.service.FrameService;

@RestController
public class FrameController {
	
	@Autowired
	private FrameService frameService;
	
	@RequestMapping("/frames")
	public List<Frame> getAllFrames() {
		return frameService.getAllFrames();
	}
	
	@RequestMapping("/frames/{id}")
	public Frame getFrame(@PathVariable("id") Long id) {
		return frameService.getFrame(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/frames")
	public void addFrame(@RequestBody Frame frame) {
		frameService.addFrame(frame);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/frames/{id}")
	public void updateFrame(@RequestBody Frame frame, @PathVariable Long id) {
		frameService.updateFrame(id, frame);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/frames/{id}")
	public void deleteFrame(@PathVariable Long id) {
		frameService.deleteFrame(id);
	}

}
