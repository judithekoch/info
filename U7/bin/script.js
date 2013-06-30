function jsonFlickrApi(response) {
 	if (response.stat != "ok"){
		return;
 	}

	window.onload = function(){
		var ul = document.createElement("ul");
		
		var photosContainer = document.getElementById("photos");
		var imageContainer = document.createElement("div");
		imageContainer.setAttribute("id", "invisible");
		photosContainer.appendChild(ul);
		
		for (var i=0; i < response.photos.photo.length; i++) {
			 	
				var photo = response.photos.photo[i];
				var url = linkURL(photo);
				var thumb = pictureThumb(photo);
				
				var li = document.createElement("li");
				
				var link = document.createElement("a");
				link.setAttribute("href", url);
							
				var img = document.createElement("img");
					img.setAttribute("src", thumb);
				//var output = document.createElement("div"); 
			 	//output.appendChild( document.createTextNode(url) );
			
			ul.appendChild(li);
			li.appendChild(link);
			link.appendChild(img);
			
			link.onclick = function(event){
				imageContainer.setAttribute("id", "singleImage")
				photosContainer.appendChild(imageContainer);
				//console.log(event);
				var singleImage = document.createElement("img");
				var exit = document.createElement("button");
				exit.setAttribute("value", "close");
				exit.innerHTML = "close";
				//singleImage.setAttribute("id", singleImage);
				img = event.target.src;
				img = img.replace("_s.jpg", "_b.jpg")

				//console.log(img);
			singleImage.setAttribute("src", img);
			imageContainer.appendChild(exit);
			imageContainer.appendChild(singleImage);
		
				return false;
			}
			
		}

	}

	// Utility-Functions: Generieren von Flickr-URLs
	// Dokumentation siehe http://www.flickr.com/services/api/misc.urls.html

	// Die URL des Fotos (Thumbnail):	
	function pictureThumb(photo) {
	 	return "http://farm" + photo.farm + ".static.flickr.com/" + photo.server + "/" +
	 	photo.id + "_" + photo.secret + "_" + "s.jpg";				
	}

	// Die URL des Fotos (Mittel):	
	function pictureMedium(photo) {
	 	return "http://farm" + photo.farm + ".static.flickr.com/" + photo.server + "/" +
	 	photo.id + "_" + photo.secret + "_" + "z.jpg";				
	}

	// Die URL des Fotos (Groß):		
	function pictureLarge(photo) {
	 	return "http://farm" + photo.farm + ".static.flickr.com/" + photo.server + "/" +
	 	photo.id + "_" + photo.secret + "_" + "b.jpg";				
	}
	
	// Die URL zur entsprechenden Seite bei Flickr:
	function linkURL(photo) {	
	 	return "http://www.flickr.com/photos/" + photo.owner + "/" + photo.id;
	}
}
