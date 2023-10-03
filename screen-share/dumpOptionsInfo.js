function dumpOptionsInfo() {
    const videoTrack = videoElem.srcObject.getVideoTracks()[0];
  
    console.log("Track settings:");
    console.log(JSON.stringify(videoTrack.getSettings(), null, 2));
    console.log("Track constraints:");
    console.log(JSON.stringify(videoTrack.getConstraints(), null, 2));
  }